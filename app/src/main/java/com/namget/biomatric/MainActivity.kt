package com.namget.biomatric


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runFingerprint()
    }



    fun runFingerprint(){
        var biometricPromptInfo : BiometricPrompt.PromptInfo
        biometricPromptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("finger print biomatric")
            .setDescription("namget tistory blog")
            .setSubtitle("namget")
            .setNegativeButtonText("Cancel")
            .build()
        val authenticationCallback = getAuthenticationCallback()
        val biometricPrompt : BiometricPrompt = BiometricPrompt(this, Executor {  }, authenticationCallback)
        biometricPrompt.authenticate(biometricPromptInfo)
    }


    private fun getAuthenticationCallback() = object : BiometricPrompt.AuthenticationCallback() {
        override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
            super.onAuthenticationError(errorCode, errString)
        }

        override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
            super.onAuthenticationSucceeded(result)
        }

        override fun onAuthenticationFailed() {
            super.onAuthenticationFailed()
        }
    }
}
