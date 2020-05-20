package com.azp.refactorrecyclerview.viewmodel

import androidx.lifecycle.ViewModel
import com.azp.refactorrecyclerview.model.InputText


class TextViewModel() : ViewModel(){
     var inputText : List<InputText> = ArrayList()

    fun getText() = inputText                   //getter

    fun setText(inputText: List<InputText>){    //setter
        this.inputText = inputText
    }

}