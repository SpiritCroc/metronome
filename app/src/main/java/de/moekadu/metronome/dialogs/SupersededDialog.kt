package de.moekadu.metronome.dialogs

import android.app.Dialog
import android.os.Bundle
import android.widget.CheckBox
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.preference.PreferenceManager
import de.moekadu.metronome.R
import androidx.core.content.edit

class SupersededDialog : DialogFragment() {
    private lateinit var checkbox: CheckBox
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = layoutInflater.inflate(R.layout.superseded_dialog, null)
        checkbox = view.findViewById(R.id.superseded_checkbox)

        val dialog = AlertDialog.Builder(requireContext()).apply {
            setTitle(R.string.note)
            setNegativeButton(R.string.acknowledged) { _, _ ->
                PreferenceManager.getDefaultSharedPreferences(requireActivity()).edit {
                    putBoolean("dont_show_superseded_dialog", checkbox.isChecked)
                }
                dismiss()
            }
            setView(view)
        }.create()

        return dialog
    }
}