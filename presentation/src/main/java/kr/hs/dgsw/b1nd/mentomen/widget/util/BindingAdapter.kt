package kr.hs.dgsw.b1nd.mentomen.widget.util

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import kr.hs.dgsw.b1nd.mentomen.R
import kr.hs.dgsw.b1nd.mentomen.widget.extension.getParentActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("image")
    fun loadImage(view: ImageView, imageUrl: String?) {
        if (imageUrl.isNullOrBlank().not()) {
            Glide.with(view.context)
                .load(imageUrl)
                .into(view)
        }
    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("date")
    fun translateDate(view: TextView, dateTime: String) {
        val now = LocalDateTime.now()
        val time = dateTime.split(".")[0]
        val convertTime = LocalDateTime.parse(time, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        val compareSecondTime = ChronoUnit.SECONDS.between(convertTime, now)
        val compareMinuteTime = ChronoUnit.MINUTES.between(convertTime, now)
        val compareHourTime = ChronoUnit.HOURS.between(convertTime, now)
        val compareDayTime = ChronoUnit.DAYS.between(convertTime, now)
        val compareMonthTime = ChronoUnit.MONTHS.between(convertTime, now)
        when {
            compareSecondTime < 60 -> view.text = "${compareSecondTime}초전"
            compareMinuteTime < 60 -> view.text = "${compareMinuteTime}분전"
            compareHourTime < 24 -> view.text = "${compareHourTime}시간전"
            compareDayTime < when (now.monthValue) {
                1, 3, 5, 7, 8, 10, 12 -> 31
                2 -> 28
                else -> 30
            } -> view.text = "${compareDayTime}일전"
            else -> view.text = "${compareMonthTime}달전"
        }
    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("grade")
    fun setGrade(view: TextView, grade: Int) {
        view.text = "${grade}학년 "
    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("room")
    fun setRoom(view: TextView, room: Int) {
        view.text = "${room}반 "
    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("number")
    fun setNumber(view: TextView, number: Int) {
        view.text = "${number}번"
    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("currentDate")
    fun setDate(view: TextView, dateTime: String?) {
        dateTime?.let {
            val time = it.split(".")[0]
            val convertTime = LocalDateTime.parse(time, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
            view.text = "${convertTime.year}.${convertTime.monthValue}.${convertTime.dayOfMonth} ${if (convertTime.hour >= 12) "오후" else "오전"} ${if (convertTime.hour >= 12) convertTime.hour - 12 else convertTime.hour}:${convertTime.minute}"
        }
    }

    @JvmStatic
    @BindingAdapter("designButtonState")
    fun setDesignButtonState(view: AppCompatButton, tagState: LiveData<TagState>) {
        val parentActivity: AppCompatActivity = view.getParentActivity() ?: return
        tagState.observe(parentActivity) {
            if (it.isDesignChecked) view.backgroundTintList = ColorStateList.valueOf(parentActivity.getColor(R.color.design))
            else view.backgroundTintList = ColorStateList.valueOf(parentActivity.getColor(R.color.gray))
        }
    }

    @JvmStatic
    @BindingAdapter("webButtonState")
    fun setWebButtonState(view: AppCompatButton, tagState: LiveData<TagState>) {
        val parentActivity: AppCompatActivity = view.getParentActivity() ?: return
        tagState.observe(parentActivity) {
            if (it.isWebChecked)  view.backgroundTintList = ColorStateList.valueOf(parentActivity.getColor(R.color.web))
            else view.backgroundTintList = ColorStateList.valueOf(parentActivity.getColor(R.color.gray))
        }
    }

    @JvmStatic
    @BindingAdapter("serverButtonState")
    fun setServerButtonState(view: AppCompatButton, tagState: LiveData<TagState>) {
        val parentActivity: AppCompatActivity = view.getParentActivity() ?: return
        tagState.observe(parentActivity) {
            if (it.isServerChecked)  view.backgroundTintList = ColorStateList.valueOf(parentActivity.getColor(R.color.server))
            else view.backgroundTintList = ColorStateList.valueOf(parentActivity.getColor(R.color.gray))
        }
    }

    @JvmStatic
    @BindingAdapter("androidButtonState")
    fun setAndroidButtonState(view: AppCompatButton, tagState: LiveData<TagState>) {
        val parentActivity: AppCompatActivity = view.getParentActivity() ?: return
        tagState.observe(parentActivity) {
            if (it.isAndroidChecked)  view.backgroundTintList = ColorStateList.valueOf(parentActivity.getColor(R.color.android))
            else view.backgroundTintList = ColorStateList.valueOf(parentActivity.getColor(R.color.gray))
        }
    }

    @JvmStatic
    @BindingAdapter("iosButtonState")
    fun setIosButtonState(view: AppCompatButton, tagState: LiveData<TagState>) {
        val parentActivity: AppCompatActivity = view.getParentActivity() ?: return
        tagState.observe(parentActivity) {
            if (it.isiOSChecked)  view.backgroundTintList = ColorStateList.valueOf(parentActivity.getColor(R.color.iOS))
            else view.backgroundTintList = ColorStateList.valueOf(parentActivity.getColor(R.color.gray))
        }
    }
}