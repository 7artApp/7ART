package com.br.seventh_art.view.login.helper

import android.util.Patterns
import android.widget.EditText

interface Utils {

    fun validateEmail(layout: EditText):Boolean {
        if (Patterns.EMAIL_ADDRESS.matcher(layout.editableText.toString()).matches()) {
            return true
        } else {
            layout.error = "E-mail Inválido"
            return false
        }
    }

    fun validatePassword(layout: EditText):Boolean{
        if (layout.editableText.toString().isNotEmpty()){
            return true
        } else {
            layout.error = "Senha Inválida"
            return false
        }
    }

    fun validateConfirmPassword(layoutPassword: EditText, layoutConfirmPassword: EditText): Boolean{
        if (layoutPassword.editableText.toString() == layoutConfirmPassword.editableText.toString()){
            return true
        } else {
            layoutConfirmPassword.error = "Senhas não correspondem"
            return false
        }
    }

    fun validateName(layout: EditText): Boolean{
        if (layout.editableText.toString().isNotEmpty()){
            return true
        }else{
            layout.error = "Nome não pode estar vazio"
            return false
        }
    }
}