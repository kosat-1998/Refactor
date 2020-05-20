package com.azp.refactorrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.azp.refactorrecyclerview.adapter.RecyclerAdapter
import com.azp.refactorrecyclerview.model.InputText
import com.azp.refactorrecyclerview.viewmodel.TextViewModel
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var textViewModel: TextViewModel
    lateinit var recyclerAdapter: RecyclerAdapter
    lateinit var manager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        manager = LinearLayoutManager(context)
        recyclerAdapter = RecyclerAdapter()

        textViewModel = ViewModelProvider(this).get(TextViewModel::class.java)
        recyclerAdapter.updateList(textViewModel.getText())




        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var inputText = ArrayList<InputText>()

        recyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = manager
        }

        btnAdd.setOnClickListener {
            if (!txtInput.text.isEmpty()) {

                var inputString = txtInput.text.toString()
                inputText.add(InputText(inputString))
                textViewModel.setText(inputText)
                recyclerAdapter.updateList(textViewModel.getText())

//                var inputText = InputText(txtInput.text.toString())
//                recyclerAdapter.data.add(inputText)
            }
            else{
                Toast.makeText(context, "Please Text Fill", Toast.LENGTH_LONG).show()
            }
        }


    }



}
