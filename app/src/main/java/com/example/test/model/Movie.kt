package com.example.test.model

import com.google.gson.annotations.SerializedName

class Movie {
    @SerializedName("id")
    private var id: String?= null

    @SerializedName("title")
    private var title: String? = null

    @SerializedName("description")
    private var description: String? = null

    @SerializedName("director")
    private var director: String? = null

    fun getID(): String? {
        return id

    }

    fun setId(id: String) {
        this.id = id
    }

   fun getTitle(): String?
    {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getDescription(): String? {
        return description

    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun getDirector(): String? {
        return director

    }

    fun setDirector(director: String) {
        this.director = director
    }


}