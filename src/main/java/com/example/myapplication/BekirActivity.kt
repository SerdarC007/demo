package com.example.myapplication

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_bekir.*
import kotlinx.android.synthetic.main.activity_main.*


class BekirActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bekir)
        mQuestionList = Constants.getQuestions()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        submit.setOnClickListener(this)


        /*

           var mMediaPlayer: MediaPlayer? = null

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bekir)
        getSupportActionBar()?.setTitle("Main")
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        mMediaPlayer = MediaPlayer.create(this, R.raw.bekir)
        mMediaPlayer.setVolume(10.0F, 10.0F)
        val am = getSystemService(Context.AUDIO_SERVICE) as AudioManager

        am.setStreamVolume(
            AudioManager.STREAM_MUSIC,
            am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
            0
        )
          var editText:EditText=findViewById<EditText>(R.id.question_1)
              var button_b: Button = findViewById<Button>(R.id.button)as Button

              button_b.setOnClickListener {
                  if (mMediaPlayer != null) {
                      mMediaPlayer.start()
                  }*/


    }

    private fun setQuestion() {

        val question = mQuestionList!![mCurrentPosition -1]
        defaultOptionsView()
        if (mCurrentPosition == mQuestionList!!.size){
            submit.text = "FINISH"
        }else{
            submit.text = "SUBMIT"
        }
        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        tv_questions.text = question!!.question

            tv_option_one.text = question.optionOne
            tv_option_two.text = question.optionTwo
            tv_option_three.text = question.optionThree
            tv_option_four.text = question.optionFour



    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)
        for (option in options) {

            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)

        }

    }


    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.submit ->{
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        }else ->{
                            Toast.makeText(this,"You are finished With Bekircim Quiz",Toast.LENGTH_SHORT)
                        }

                    }
                }
                else{
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }

                        answerView(mSelectedOptionPosition,R.drawable.correct_option_border_bg)
                        if (mCurrentPosition == mQuestionList!!.size){
                            submit.text = "FINISHED"
                        }else{
                            submit.text = "GO TO NEXT QUESTION"
                        }
                    mSelectedOptionPosition = 0

                }

            }
        }
    }
    private  fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 ->{
                tv_option_one.background = ContextCompat.getDrawable(this,drawableView
                )
            }
            2 ->{
                tv_option_two.background = ContextCompat.getDrawable(this,drawableView
                )
            }
            3 ->{
                tv_option_three.background = ContextCompat.getDrawable(this,drawableView
                )
            }
            4 ->{
                tv_option_four.background = ContextCompat.getDrawable(this,drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()
        if (textView != null) {
            mSelectedOptionPosition = selectedOptionNum

            textView.setTextColor(Color.parseColor("#363A43"))
            textView.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)

        }
    }

}



