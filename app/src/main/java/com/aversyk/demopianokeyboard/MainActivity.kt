package com.aversyk.demopianokeyboard

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.aversyk.librarypianokeyboard.keyBoard.Key
import com.aversyk.librarypianokeyboard.keyBoard.PianoKeyBoard
import com.aversyk.librarypianokeyboard.sound.SoundPlayUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var keyCount = 8
    private var blackKeyHeightRatio = 0.6f
    private var keyBoardColorType = 0
    private var keyBoardTextType = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SoundPlayUtils.init(this)
        keyBoard?.setKeyListener(object : PianoKeyBoard.KeyListener {
            override fun onKeyPressed(key: Key?) {
                //某个键被按下的回调
            }

            override fun onKeyUp(key: Key?) {
                //某个键被松开的回调
            }

            override fun currentFirstKeyPosition(position: Int) {
                //键盘显示的第一个键的index/position更新回调
                seekBar?.max = keyBoard?.maxMovePosition ?: 0
                seekBar?.progress = position
            }

        })
        seekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                keyBoard?.moveToPosition(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                seekBar?.max = keyBoard?.maxMovePosition ?: 0
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })
        button1?.setOnClickListener {
            if (seekBar?.progress?:0 > (keyBoard?.maxMovePosition?.minus(1)?:0)) {
                keyBoard?.moveToPosition(keyBoard?.maxMovePosition?.minus(1)?:0)
            } else {
                keyBoard?.showPrevious()
            }
            //keyBoard?.setPronuncTextDimension(12 * resources.displayMetrics.scaledDensity)
        }
        button2?.setOnClickListener {
            if (seekBar?.progress?:0 < 2) {
                keyBoard?.moveToPosition(2)
            } else {
                keyBoard?.showNext()
            }
        }
        object : CountDownTimer(500, 500) {
            override fun onTick(l: Long) {}
            override fun onFinish() {
                //keyBoard?.moveToPosition(2)
            }
        }.start()
        button3?.setOnClickListener {
            if (keyCount < 32) {
                keyCount++
                keyBoard?.setKeyCount(keyCount)
                textView2?.text = "$keyCount"
            } else {
                Toast.makeText(this, "为了更好的用户体验最好不要小于8个", Toast.LENGTH_SHORT).show()
            }
        }
        button4?.setOnClickListener {
            if (keyCount > 8) {
                keyCount--
                keyBoard?.setKeyCount(keyCount)
                textView2?.text = "$keyCount"
            } else {
                Toast.makeText(this, "为了更好的用户体验最好不要大于32个", Toast.LENGTH_SHORT).show()
            }
        }
        button5?.setOnClickListener {
            if (blackKeyHeightRatio < 0.9f) {
                blackKeyHeightRatio += 0.1f
                keyBoard?.setBlackKeyHeightRatio(blackKeyHeightRatio)
                textView4?.text = "$blackKeyHeightRatio"
            } else {
                Toast.makeText(this, "为了更好的用户体验最好不要小于8个", Toast.LENGTH_SHORT).show()
            }
        }
        button6?.setOnClickListener {
            if (keyCount > 0.2f) {
                blackKeyHeightRatio -= 0.1f
                keyBoard?.setBlackKeyHeightRatio(blackKeyHeightRatio)
                textView4?.text = "$blackKeyHeightRatio"
            } else {
                Toast.makeText(this, "为了更好的用户体验最好不要大于32个", Toast.LENGTH_SHORT).show()
            }
        }
        button7?.setOnClickListener {
            keyBoardColorType = if (keyBoardColorType == 0) {
                1
            } else {
                0
            }
            swithKeyBoardPressedDrawable(keyBoardColorType)
        }
        button8?.setOnClickListener {
            keyBoardTextType = if (keyBoardTextType == 1) {
                2
            } else if (keyBoardTextType == 2) {
                3
            } else {
                1
            }
            keyBoard?.setPronuncTextType(keyBoardTextType)
        }
    }

    private fun swithKeyBoardPressedDrawable(type: Int){
        when(type) {
            1 -> {
                keyBoard?.setWhiteKeyPressedDrawable(ContextCompat.getDrawable(this, R.drawable.ic_piano_keyboard_whitekey_down_green) as BitmapDrawable?)
                keyBoard?.setBlackKeyPressedDrawable(ContextCompat.getDrawable(this, R.drawable.ic_piano_keyboard_blackkey_down_green) as BitmapDrawable?)
            }
            else -> {
                keyBoard?.setWhiteKeyPressedDrawable(ContextCompat.getDrawable(this, R.drawable.ic_piano_keyboard_whitekey_down_red) as BitmapDrawable?)
                keyBoard?.setBlackKeyPressedDrawable(ContextCompat.getDrawable(this, R.drawable.ic_piano_keyboard_blackkey_down_red) as BitmapDrawable?)
            }
        }
    }

}