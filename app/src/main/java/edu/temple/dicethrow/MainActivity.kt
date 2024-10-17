package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private lateinit var dieFragment: DieFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*
        // Find the DieFragment using the FragmentContainerView
        dieFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as DieFragment

        // Set up the button to roll the die
        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            dieFragment.throwDie()
        }

         */


        if (savedInstanceState == null) {
            dieFragment = DieFragment.newInstance(6) // 6 sides
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, dieFragment)
                .commit()
        } else {
            dieFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as DieFragment
        }

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            dieFragment.throwDie()
        }


    }
}