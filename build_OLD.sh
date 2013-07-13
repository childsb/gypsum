#! /bin/sh

osxBuild(){
    echo "Running osx build.."
	JTUXSRC="./jtux"
	INCLUDEPATH=/System/Library/Frameworks/JavaVM.framework/Versions/Current/Headers
    COPTS="-Wimplicit -Wstrict-prototypes -Wall -Wno-unknown-pragmas -D_REENTRANT -D_THREAD_SAFE -std=c99 -fnested-functions "

    gcc $COPTS -fPIC -c -DDARWIN -D__DARWIN_UNIX03 -I$JTUXSRC -I$JTUXSRC/include -I$INCLUDEPATH -I$INCLUDEPATH/solaris $JTUXSRC/jtux*.c
   # gcc -o libjtux.jnilib -dynamiclib -framework JavaVM *.o
}

linuxBuild(){
  INCLUDEPATH="${JAVA_HOME}/include"
  COPTS="-Wimplicit -Wstrict-prototypes -Wall -Wno-unknown-pragmas -D_REENTRANT -D_THREAD_SAFE -std=c99"
  gcc $COPTS -fPIC -c -DSOLARIS -I. -Ijtux/include -I$INCLUDEPATH I$INCLUDEPATH/solaris jtux/jtux*.c
  
  gcc -o libjtux.so -shared -lrt -lsocket -lnsl *.o

}

make(){
 makefile='unknown'
 unamestr=`uname`
 if [[ "$unamestr" == 'Linux' ]]; then
   makefile='Makefile.linux'
 elif [[ "$unamestr" == 'Darwin' ]]; then
   makefile='Makefile.osx'
 fi
 rm -f Makefile
 mv $makeFile Makefile
 make clean
 make

}

fetch(){
 wget http://www.basepath.com/aup/jtux/jtux.tar.gz
 tar xvf jtux.tar.gz
 mkdir -p src/main/java/jtux
 mv jtux/*.java src/main/java/jtux
 rm -f jtux.tar.gz 
}

# fetch
unamestr=`uname`
if [[ "$unamestr" == 'Linux' ]]; then
  linuxBuild
elif [[ "$unamestr" == 'Darwin' ]]; then
  osxBuild
fi

