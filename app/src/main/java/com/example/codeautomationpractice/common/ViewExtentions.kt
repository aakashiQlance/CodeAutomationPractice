package com.example.codeautomationpractice.common

import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

import java.io.File

fun View.snack(@StringRes msg: Int) {
    Snackbar.make(this, context.getString(msg), Snackbar.LENGTH_SHORT).show()
}

fun View.snack(msg: String, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, msg, duration).show()
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.inVisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

/*@SuppressLint("CheckResult")
fun ImageView.loadImage(
    url: String?,
    height: Int? = null,
    width: Int? = null,
    default: Int = R.mipmap.ic_launcher_adaptive_fore,
    isCircle: Boolean = false
) {
    val requestOption: RequestOptions = RequestOptions()
        .placeholder(default)
        .error(default)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .transform(RoundedCorners(8.toPx))

    if (isCircle)
        requestOption.transform(CircleCrop())

    if (height != null && width != null) {
        requestOption.override(height, width)
        Glide.with(this.context)
            .load(url)
            .apply(requestOption)
            .into(this)
    } else {
        Glide.with(this.context)
            .load(url)
            .apply(requestOption)
            .into(this)
    }
}

fun ImageView.loadImageWithPlaceHolder(img: String, placeHolder: Int) {
    Glide.with(this.context)
        .load(img)
        .placeholder(placeHolder)
        .into(this)
}

fun ImageView.loadImageWithProgressBar(url: String, progressBar: ProgressBar) {
    progressBar.visible()
    this.inVisible()
    Glide.with(this.context)
        .load(url)
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: com.bumptech.glide.request.target.Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                progressBar.gone()
                this@loadImageWithProgressBar.visible()
                return false
            }

            override fun onResourceReady(
                resource: Drawable,
                model: Any,
                target: com.bumptech.glide.request.target.Target<Drawable>?,
                dataSource: DataSource,
                isFirstResource: Boolean
            ): Boolean {
                progressBar.gone()
                this@loadImageWithProgressBar.visible()
                return false
            }
        }).into(this)

}

fun ImageView.loadImage(@DrawableRes res: Int, height: Int? = null, width: Int? = null) {
    if (height != null && width != null) {
        Glide.with(this.context)
            .load(res)
            .apply(RequestOptions().override(height, width))
            .into(this)

    } else {
        Glide.with(this.context)
            .load(res)
            .into(this)
    }
}

fun ImageView.loadImage(uri: Uri, height: Int? = null, width: Int? = null) {
    if (height != null && width != null) {
        Glide.with(this.context)
            .load(uri)
            .apply(RequestOptions().override(height, width))
            .into(this)

    } else {
        Glide.with(this.context)
            .load(uri)
            .into(this)
    }
}

fun ImageView.loadImage(uri: String, height: Int? = null, width: Int? = null, placeholder: Int) {
    if (height != null && width != null) {
        Glide.with(this.context)
            .load(uri)
            .apply(RequestOptions().override(height, width))
            .into(this)

    } else {
        Glide.with(this.context)
            .load(uri)
            .placeholder(placeholder)
            .into(this)
    }
}


fun ImageView.loadImage(file: File, height: Int? = null, width: Int? = null) {
    if (height != null && width != null) {
        Glide.with(this.context).asBitmap()
            .load(file)
            .apply(RequestOptions().override(height, width))
            .into(this)

    } else {
        Glide.with(this.context).asBitmap()
            .load(file)
            .into(this)
    }
}

fun View.backgroundPattensBorderRed() {
    this.background =
        ContextCompat.getDrawable(this.context, R.drawable.drawable_pattens_border_red)
}

fun View.backgroundWhiteBorderRed() {
    this.background =
        ContextCompat.getDrawable(this.context, R.drawable.drawable_rounded_corner_white_red_border)
}

fun View.backgroundOrange() {
    this.background =
        ContextCompat.getDrawable(this.context, R.drawable.drawable_rounded_corner_orange)
}

fun View.backgroundYellow() {
    this.background =
        ContextCompat.getDrawable(this.context, R.drawable.drawable_rounded_corner_yellow)
}

fun View.backgroundRed() {
    this.background =
        ContextCompat.getDrawable(this.context, R.drawable.drawable_rounded_corner_red)
}

fun View.backgroundAtlantis() {
    this.background =
        ContextCompat.getDrawable(this.context, R.drawable.drawable_rounded_corner_atlantis)
}

fun View.backgroundPattensBorderGreen() {
    this.background =
        ContextCompat.getDrawable(this.context, R.drawable.drawable_rounded_corner_gree_line)
}

fun View.backGroundPattens() {
    this.background =
        ContextCompat.getDrawable(this.context, R.drawable.drawable_rounded_corner_pattens_blue)
}*/

