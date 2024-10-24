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
        *
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, BlankFragment())
                .commit()
        }
        * */


        if (savedInstanceState == null) {
            // call newInstance function of the DieFragment object
            dieFragment = DieFragment.newInstance(6) // 6 sides

            // use transaction to save the state
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, dieFragment)
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()
        } else {
            dieFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as DieFragment
        }


        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            dieFragment.throwDie()

        }

        
        /*
        if (savedInstanceState == null) {
            // call newInstance function of the DieFragment object
            dieFragment = DieFragment.newInstance(6) // 6 sides

            // use transaction to save the state
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, dieFragment)
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()

        } else {
            dieFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as DieFragment
        }


        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, DieFragment.newInstance(6))
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()
        }
        */


    }
}

