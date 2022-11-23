package com.example.codeautomationpractice

import android.util.Log
import com.example.codeautomationpractice.common.AppConstants
import com.example.codeautomationpractice.model.EditTextParams

object CreateView {

    var attributeStatements = AttributeStatements
    fun textView() {

    }

    fun textInputEditText(editTextParams: EditTextParams): String {

//        var codeMap = HashMap<String,String>()



        val stringBuffer = StringBuffer()

        stringBuffer.append(attributeStatements.layoutHeight(editTextParams.height))
        stringBuffer.append(attributeStatements.layoutWidth(editTextParams.width))
        if (editTextParams.weight) stringBuffer.append(attributeStatements.layoutWeight())
        if(!editTextParams.margin.isNullOrEmpty()) stringBuffer.append(attributeStatements.layoutMargin(editTextParams.margin))
        if(!editTextParams.marginHorizontal.isNullOrEmpty()) stringBuffer.append(attributeStatements.layoutMarginHorizontal(editTextParams.marginHorizontal))
        if(!editTextParams.marginVertical.isNullOrEmpty()) stringBuffer.append(attributeStatements.layoutMarginVertical(editTextParams.marginVertical))
        if(!editTextParams.marginTop.isNullOrEmpty()) stringBuffer.append(attributeStatements.layoutMarginTop(editTextParams.marginTop))
        if(!editTextParams.marginBottom.isNullOrEmpty()) stringBuffer.append(attributeStatements.layoutMarginBottom(editTextParams.marginBottom))
        if(!editTextParams.marginStart.isNullOrEmpty()) stringBuffer.append(attributeStatements.layoutMarginStart(editTextParams.marginStart))
        if(!editTextParams.marginEnd.isNullOrEmpty()) stringBuffer.append( attributeStatements.layoutMarginEnd(editTextParams.marginEnd))

        Log.i("Code",stringBuffer.toString())

        return stringBuffer.toString()
    }

}