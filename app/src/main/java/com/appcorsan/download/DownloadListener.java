package com.appcorsan.download;

/**
 * Created by sala01 on 15/05/2017.
 */

public interface DownloadListener<T> {

    void finishedDownload(T t) ;
}
