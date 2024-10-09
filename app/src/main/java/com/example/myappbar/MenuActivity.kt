package com.example.myappbar

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myappbar.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            // Menghubungkan searchView dengan searchBar
            searchView.setupWithSearchBar(searchBar)

            // Listener untuk searchView ketika user melakukan search
            searchView.editText.setOnEditorActionListener { textView, actionId, event ->
                searchBar.setText(searchView.text)
                searchView.hide()
                Toast.makeText(this@MenuActivity, searchView.text, Toast.LENGTH_SHORT).show()
                false
            }

            searchBar.inflateMenu(R.menu.option_menu)

            searchBar.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.menu2 -> {
                        Toast.makeText(this@MenuActivity, "Menu item clicked", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        }
    }
}
