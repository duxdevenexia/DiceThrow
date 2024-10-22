package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {

    val DIESIDE = "sidenumber"

    lateinit var dieTextView: TextView

    var dieSides: Int = 6

    private var currentDieNumber = 0

    val KEY: String = "currentDieNumber"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        savedInstanceState?.run {
            currentDieNumber = getInt(dieTextView.text.toString(), 0)
        }

        if (currentDieNumber == 0) {
            throwDie()
            view.setOnClickListener{
                throwDie()
            }
        }
        else {

        }

         */

        savedInstanceState?.let {
            currentDieNumber = it.getInt(KEY, 0)
            dieTextView.text = currentDieNumber.toString()
        } ?: throwDie()

        view.setOnClickListener {
            throwDie()
        }

        /*
        savedInstanceState?.run {
            rollValue.
        }

         */
    }


    fun throwDie() {
        currentDieNumber = Random.nextInt(1, dieSides + 1)
        dieTextView.text = currentDieNumber.toString()
    }


    companion object {
        private const val DIESIDE = "sidenumber"

        fun newInstance(sides: Int): DieFragment {
            val fragment = DieFragment()
            val args = Bundle().apply {
                putInt(DIESIDE, sides)
            }

            fragment.arguments = args
            return fragment
        }
    }

    // onSaveInstanceState
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //outState.putInt(KEY, currentDieNumber)


    }

}

