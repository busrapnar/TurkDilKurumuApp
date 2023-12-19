package com.busrapinar.turkdilkurumuapp.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.busrapinar.turkdilkurumuapp.R
import com.busrapinar.turkdilkurumuapp.data.Atasozu
import com.busrapinar.turkdilkurumuapp.databinding.ActivityHomeBinding
import com.busrapinar.turkdilkurumuapp.util.gone
import com.busrapinar.turkdilkurumuapp.util.visible
import com.busrapinar.turkdilkurumuapp.view.adapter.WordsAdapter
import com.busrapinar.turkdilkurumuapp.view.fragment.MenuFragment
import com.busrapinar.turkdilkurumuapp.view.viewModel.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: WordsAdapter
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        initViewModel()
        initObservers()
        setupToolbar()
        initListeners()
        setupBottomNavigationView()
        viewModel.getAtasozu()

    }

    private fun initListeners() {
        binding.apply {
            rootView.setOnClickListener {
                val fragmentManager = supportFragmentManager
                for (fragment in fragmentManager.fragments) {
                    fragmentManager.beginTransaction().remove(fragment).commit()
                }
                fragmentManager.executePendingTransactions()
            }
        }
    }

    private fun initBinding() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }

    private fun initObservers() {
        viewModel.mutableAtasozuResponse.observe(this@HomeActivity) {
            initAdapter(it.atasozu)
        }
    }

    private fun setupToolbar() {
        binding.toolbar.title = ""
        setSupportActionBar(binding.toolbar)
    }

    private fun initAdapter(data: List<Atasozu>) {
        adapter = WordsAdapter(data, ::adapterClicked)
        binding.rvWord.adapter = adapter
    }

    private fun adapterClicked(data: Int) {
        val intent = Intent(this@HomeActivity, KelimeDetayActivity::class.java)
        intent.putExtra("KEY_DATA", data)
        startActivity(intent)
    }

    private fun setupBottomNavigationView() {
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_item1 -> true
                R.id.menu_item2 -> true
                R.id.menu_item3 -> true
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_menu -> {
                showBottomSheetDialog()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    /*private fun showContactDialog() {
         val dialog = Dialog(this)
         dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
         dialog.setContentView(R.layout.activity_tdkmenu)
         //setBottomSheetItemListeners(dialog)
         dialog.show()
         dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
         dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
         dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
         dialog.window?.setGravity(Gravity.BOTTOM)

     }*/
    private fun initNavigationView() {
        // NavHostFragment'ı oluştur
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, navHostFragment)
            .setPrimaryNavigationFragment(navHostFragment)
            .commit()
    }

    private fun showBottomSheetDialog() {
        binding.navHostFragment.visible()
        val navHostFragment = NavHostFragment.create(R.navigation.nav_info)
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, navHostFragment).commit()
    }

    private fun showToast(message: String) {
        Toast.makeText(this@HomeActivity, message, Toast.LENGTH_SHORT).show()
    }


    /*private fun populateWordList() {
        val w1 = Word(1, "Bir Deyim", "on para", "çok az (para).")
        val w2 = Word(2, "Bir deyim - Atasözü", "siyem siyem ağlamak", "hafif hafif, ince ince durmadan gözyaşı dökmek.")
        val w3 = Word(3, "Atasözleri ve Deyimler", "kalemiyle yaşamak", "geçimini yazıları ile sağlamak")

        wordsList = ArrayList()
        wordsList.add(w1)
        wordsList.add(w2)
        wordsList.add(w3)
    }
    */
}