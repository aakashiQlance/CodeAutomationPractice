package com.example.codeautomationpractice

object AttributeStatements {

    fun layoutHeight(height: String): String {
        return "android:layout_height=\"$height\"\n"
    }

    fun layoutWidth(width: String): String {
        return "android:layout_width=\"$width\"\n"
    }

    fun layoutWeight(): String {
        return "android:layout_weight=\"1\"\n"
    }

    fun layoutMargin(margin: String): String {
        return "android:layout_margin=\"${margin}dp\"\n"
    }

    fun layoutMarginHorizontal(marginHorizontal: String): String {
        return "android:layout_marginHorizontal=\"${marginHorizontal}dp\"\n"
    }

    fun layoutMarginVertical(marginVertical: String): String {
        return "android:layout_marginVertical=\"${marginVertical}dp\"\n"
    }

    fun layoutMarginTop(marginTop: String): String {
        return "android:layout_marginTop=\"${marginTop}dp\"\n"
    }

    fun layoutMarginBottom(marginBottom: String): String {
        return "android:layout_marginBottom=\"${marginBottom}dp\"\n"
    }

    fun layoutMarginStart(marginStart: String): String {
        return "android:layout_marginStart=\"${marginStart}dp\"\n"
    }

    fun layoutMarginEnd(marginEnd: String): String {
        return "android:layout_marginEnd=\"${marginEnd}dp\"\n"
    }

}