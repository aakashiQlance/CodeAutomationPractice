package com.example.codeautomationpractice

import android.util.Log
import com.example.codeautomationpractice.common.gone
import com.example.codeautomationpractice.common.visible
import com.example.codeautomationpractice.databinding.ActivityMainBinding
import com.example.codeautomationpractice.model.EditTextParams

class MainActivity : BaseActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private var selectedRadioHeightText = ""
    private var selectedRadioWidthText = ""
    private var weightSelected = false
    private var marginValue = ""
    private var marginHorizontalValue = ""
    private var marginVerticalValue = ""
    private var marginTopValue = ""
    private var marginBottomValue = ""
    private var marginStartValue = ""
    private var marginEndValue = ""


    override fun getResource(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        mBinding = getBinding()
        mBinding.checkAddCustomMargin.setOnCheckedChangeListener { compoundButton, b ->
            if (compoundButton.isChecked) {
                mBinding.CustomMarginLL.visible()
            } else {
                mBinding.CustomMarginLL.gone()
            }
        }
        mBinding.rdGroupHeight.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rdHeightMatchParent -> {
                    selectedRadioHeightText = mBinding.rdHeightMatchParent.text.toString()
                }
                R.id.rdHeightWrapParent -> {
                    selectedRadioHeightText = mBinding.rdHeightWrapParent.text.toString()

                }
                R.id.rdHeight0DP -> {
                    selectedRadioHeightText = mBinding.rdHeight0DP.text.toString()
                    Log.i("CheckedText",selectedRadioHeightText.toString())
                }
            }
        }
        mBinding.rdGroupWidth.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rdWidthMatchParent -> {
                    selectedRadioWidthText = mBinding.rdHeightMatchParent.text.toString()
                }
                R.id.rdWidthWrapParent -> {
                    selectedRadioWidthText = mBinding.rdHeightWrapParent.text.toString()
                    Log.i("CheckedText",selectedRadioWidthText.toString())

                }
                R.id.rdWidth0dp -> {
                    selectedRadioWidthText = mBinding.rdHeight0DP.text.toString()
                }
            }
        }
        mBinding.checkAddCustomMargin.setOnCheckedChangeListener { compoundButton, b ->
            if(compoundButton.isChecked) mBinding.customMarginViewsLL.visible()
            else mBinding.customMarginViewsLL.gone()
        }
    }

    override fun initObserver() {

    }

    override fun handleListener() {
        mBinding.btnGenerateEditText.setOnClickListener {
            mBinding.tvCode.text = CreateView.textInputEditText(getTextInputEditTextParams())
        }
    }

    private fun getTextInputEditTextParams(): EditTextParams {

        if (mBinding.checkBoxWeight1.isChecked) {
            weightSelected = true
        }

        marginValue = mBinding.edMarginValue.text.toString()

        marginHorizontalValue = mBinding.edMarginHorizontalValue.text.toString()

        marginVerticalValue = mBinding.edMarginVerticalValue.text.toString()

        marginTopValue = mBinding.edMarginTopValue.text.toString()

        marginBottomValue = mBinding.edMarginBottomValue.text.toString()


        marginStartValue = mBinding.edMarginStartValue.text.toString()


        marginEndValue = mBinding.edMarginEndValue.text.toString()
        Log.i("CheckedTextButton","$selectedRadioHeightText : $selectedRadioWidthText")
        return EditTextParams(
            height = selectedRadioHeightText,
            width = selectedRadioWidthText,
            weight = weightSelected,
            margin = marginValue,
            marginHorizontal = marginHorizontalValue,
            marginVertical = marginVerticalValue,
            marginTop = marginTopValue,
            marginBottom = marginBottomValue,
            marginStart = marginStartValue,
            marginEnd = marginEndValue,
        )

    }


}