package com.kendis.myapplication.data

import com.kendis.myapplication.model.MarsPhoto
import com.kendis.myapplication.network.MarsApiService
import javax.inject.Inject

class DefaultMarsPhotoRepository @Inject constructor(private val marsApiService: MarsApiService) :
    MarsPhotoRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> = marsApiService.getPhotos()
}
