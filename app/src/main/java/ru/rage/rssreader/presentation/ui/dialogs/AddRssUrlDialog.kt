package ru.rage.rssreader.presentation.ui.dialogs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_add_rss_url.*
import ru.rage.rssreader.R

class AddRssUrlDialog : DialogFragment() {

    companion object {

        fun getInstance(): AddRssUrlDialog {
            return AddRssUrlDialog()
        }

    }

    private var callback: AddOrDeleteCallback? = null

    interface AddOrDeleteCallback {
        fun onAdd(name: String, url: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val parent = parentFragment
        val activity = activity
        if (parent is AddOrDeleteCallback) {
            callback = parent
        } else if (activity is AddOrDeleteCallback) {
            callback = activity
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_add_rss_url, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add.setOnClickListener {
            callback?.onAdd(name.text.toString(), url.text.toString())
            dismiss()
        }
    }

}