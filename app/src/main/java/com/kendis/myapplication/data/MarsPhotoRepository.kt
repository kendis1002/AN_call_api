package com.kendis.myapplication.data

import com.kendis.myapplication.model.MarsPhoto

interface MarsPhotoRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}
