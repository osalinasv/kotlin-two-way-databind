package com.omarsalinas.databinding.models

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import com.omarsalinas.databinding.BR

class MainViewModel : BaseObservable() {

    var password : String = ""
        @Bindable get
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.password)
            }
        }

    var passwordRevealed : Int = View.GONE
        @Bindable get

    fun setPasswordRevealed(value : Boolean) {
        this.passwordRevealed = if (value) View.VISIBLE else View.GONE
        notifyPropertyChanged(BR.passwordRevealed)
    }

    @Bindable("password")
    fun getPasswordQuality() : String {
        return if (this.password.isEmpty()) {
            "Enter a password"
        } else if (this.password.length < 5) {
            "Too short"
        } else {
            "Good enough"
        }
    }

    fun revealPassword() {
        setPasswordRevealed(true)
    }

    @Bindable("password")
    fun getCurrentPassword() : String {
        return "Current password: ${this.password}"
    }
}