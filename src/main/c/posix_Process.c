#include <jni.h>
#include <sys/types.h>
#include <unistd.h>
#include "posix_Process.h"	/*double quotes tells it to search current directory*/
  
JNIEXPORT jint JNICALL Java_posix_Process_setuid (JNIEnv * jnienv, jclass j, jint uid){
    return((jint)setuid((uid_t)uid));
}

JNIEXPORT jint JNICALL Java_posix_Process_seteuid (JNIEnv * jnienv, jclass j, jint uid){
    return((jint)seteuid((uid_t)uid));
}

JNIEXPORT jint JNICALL Java_posix_Process_setgid (JNIEnv * jnienv, jclass j, jint gid){
    return((jint)setgid((uid_t)gid));
}

JNIEXPORT jint JNICALL Java_posix_Process_setegid (JNIEnv * jnienv, jclass j, jint gid){
    return((jint)setegid((uid_t)gid));
}
