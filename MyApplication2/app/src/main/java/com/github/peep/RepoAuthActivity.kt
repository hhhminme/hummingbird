package com.github.peep

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.github.peep.databinding.ActivityRepoAuthBinding
import com.github.peep.databinding.ActivitySplashBinding
import kotlinx.android.synthetic.main.activity_repo_auth.*
import org.jetbrains.anko.toast

class RepoAuthActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityRepoAuthBinding
    private var focus = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRepoAuthBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.publicRadio.setOnClickListener {
            mBinding.publicRadioImg.visibility = View.VISIBLE
            mBinding.privateRadioImg.visibility = View.GONE
            focus = 1

        }

        mBinding.privateRadio.setOnClickListener {
            mBinding.publicRadioImg.visibility = View.GONE
            mBinding.privateRadioImg.visibility = View.VISIBLE
            focus = 2
        }

        mBinding.startButton.setOnClickListener {
            if (focus == 0) {
                toast("버튼을 선택해주세요")
            } else if (focus == 1) {
                intent.putExtra("auth", "public")
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else if (focus == 2) {
                intent.putExtra("auth", "private")
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}