package com.example.a30daysofmusic

import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load

class ChallengeAdapter(
    private val challenges: List<MusicChallenge>
) : RecyclerView.Adapter<ChallengeAdapter.ChallengeViewHolder>() {

    class ChallengeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dayText: TextView = view.findViewById(R.id.day_text)
        val titleText: TextView = view.findViewById(R.id.title_text)
        val challengeImage: ImageView = view.findViewById(R.id.challenge_image)
        val descriptionText: TextView = view.findViewById(R.id.description_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_challenge, parent, false)
        return ChallengeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChallengeViewHolder, position: Int) {
        val challenge = challenges[position]
        val context = holder.itemView.context

        holder.dayText.text = context.getString(challenge.dayRes)
        holder.titleText.text = context.getString(challenge.titleRes)
        holder.challengeImage.load(challenge.imageRes)
        holder.descriptionText.text = context.getString(challenge.descriptionRes)

        // Lógica para la animación de expandir/contraer
        holder.itemView.setOnClickListener {
            val isDescriptionVisible = holder.descriptionText.visibility == View.VISIBLE

            if (isDescriptionVisible) {
                // Si está visible, la ocultamos
                holder.descriptionText.visibility = View.GONE
            } else {
                // Si está oculta, la mostramos con una animación de fade-in
                holder.descriptionText.visibility = View.VISIBLE
                ObjectAnimator.ofFloat(holder.descriptionText, "alpha", 0f, 1f).apply {
                    duration = 500
                    start()
                }
            }
        }
    }

    override fun getItemCount() = challenges.size
}