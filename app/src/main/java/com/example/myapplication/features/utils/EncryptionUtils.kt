package com.example.myapplication.features.utils

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.security.keystore.UserNotAuthenticatedException
import android.util.Log
import androidx.biometric.BiometricPrompt
import java.nio.charset.Charset
import java.security.InvalidKeyException
import java.security.KeyStore
import java.util.*
import java.util.concurrent.Executor
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

class EncryptionUtils {

    companion object {
        const val KEY_NAME: String = "androiddebugkey"
        const val VALIDITY_DURATION_SECONDS = 5
        const val ALLOWED_AUTHENTICATORS = KeyProperties.KEY_ALGORITHM_AES
    }

    fun generateSecretKey() {
        val keyGenerator = KeyGenerator.getInstance(
            KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore"
        )
        keyGenerator.init(getKeyGenParameterSpec())
        keyGenerator.generateKey()
    }

    private fun getSecretKey(): SecretKey {
        val keyStore = KeyStore.getInstance("AndroidKeyStore")

        // Before the keystore can be accessed, it must be loaded.
        keyStore.load(null)
        return keyStore.getKey(KEY_NAME, null) as SecretKey
    }

    private fun getCipher(): Cipher {
        return Cipher.getInstance(
            KeyProperties.KEY_ALGORITHM_AES + "/"
                    + KeyProperties.BLOCK_MODE_CBC + "/"
                    + KeyProperties.ENCRYPTION_PADDING_PKCS7
        )
    }


    private fun getKeyGenParameterSpec(): KeyGenParameterSpec {
        return KeyGenParameterSpec.Builder(
            KEY_NAME,
            KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
        )
            .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
            .setUserAuthenticationRequired(true)
            .build()
    }

    private fun encryptSecretInformation(plainTextPassword: String) {
        // Exceptions are unhandled for getCipher() and getSecretKey().
        val cipher = getCipher()
        val secretKey = getSecretKey()
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey)
            val encryptedInfo: ByteArray = cipher.doFinal(
                plainTextPassword.toByteArray(Charset.defaultCharset())
            )
            Log.d(
                "MY_APP_TAG", "Encrypted information: " +
                        Arrays.toString(encryptedInfo)
            )
        } catch (e: InvalidKeyException) {
            Log.e("MY_APP_TAG", "Key is invalid.")
        } catch (e: UserNotAuthenticatedException) {
            Log.d("MY_APP_TAG", "The key's validity timed out.")
        }
    }


}
