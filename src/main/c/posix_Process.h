/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class posix_Process */

#ifndef _Included_posix_Process
#define _Included_posix_Process
#ifdef __cplusplus
extern "C" {
#endif
#undef posix_Process_SUCCESS
#define posix_Process_SUCCESS 0L
#undef posix_Process_FAILURE
#define posix_Process_FAILURE -1L
/*
 * Class:     posix_Process
 * Method:    setuid
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_posix_Process_setuid
  (JNIEnv *, jclass, jint);

/*
 * Class:     posix_Process
 * Method:    seteuid
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_posix_Process_seteuid
  (JNIEnv *, jclass, jint);

/*
 * Class:     posix_Process
 * Method:    setgid
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_posix_Process_setgid
  (JNIEnv *, jclass, jint);

/*
 * Class:     posix_Process
 * Method:    setegid
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_posix_Process_setegid
  (JNIEnv *, jclass, jint);

#ifdef __cplusplus
}
#endif
#endif
