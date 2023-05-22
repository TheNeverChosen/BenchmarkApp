ANDROID_OUT=./
ANDROID_SDK=~/Android/Sdk
NDK_BIN=$(ANDROID_SDK)/ndk/25.2.9519653/toolchains/llvm/prebuilt/linux-x86_64/bin

android-armv7a: ABI=armeabi-v7a
android-arm64: ABI=arm64-v8a
android-x86: ABI=x86
android-x86_64: ABI=x86_64

GMP_PATH=/home/fernando/Documents/AndroidStudioProjects/BenchmarkApp/app/src/main/jni/gmp
FILES=./main.go ./go_pidigits.go ./go_nbody.go ./go_fasta.go ./go_fannkuch.go ./go_binarytrees.go

all: android-armv7a android-arm64 android-x86 android-x86_64

android-armv7a:
	CGO_ENABLED=1 \
	GOOS=android \
	GOARCH=arm \
	GOARM=7 \
	CC=$(NDK_BIN)/armv7a-linux-androideabi21-clang \
	CGO_CFLAGS="-O2 -g -I$(GMP_PATH)/$(ABI)" \
	CGO_LDFLAGS="-O2 -g -L$(GMP_PATH)/$(ABI)" \
	go build -buildmode=c-shared -o $(ANDROID_OUT)/$(ABI)/goalgo.so $(FILES)

android-arm64:
	CGO_ENABLED=1 \
	GOOS=android \
	GOARCH=arm64 \
	CC=$(NDK_BIN)/aarch64-linux-android21-clang \
	CGO_CFLAGS="-O2 -g -I$(GMP_PATH)/$(ABI)" \
	CGO_LDFLAGS="-O2 -g -L$(GMP_PATH)/$(ABI)" \
	go build -buildmode=c-shared -o $(ANDROID_OUT)/$(ABI)/goalgo.so $(FILES)

android-x86:
	CGO_ENABLED=1 \
	GOOS=android \
	GOARCH=386 \
	CC=$(NDK_BIN)/i686-linux-android21-clang \
	CGO_CFLAGS="-O2 -g -I$(GMP_PATH)/$(ABI)" \
	CGO_LDFLAGS="-O2 -g -L$(GMP_PATH)/$(ABI)" \
	go build -buildmode=c-shared -o $(ANDROID_OUT)/$(ABI)/goalgo.so $(FILES)

android-x86_64:
	CGO_ENABLED=1 \
	GOOS=android \
	GOARCH=amd64 \
	CC=$(NDK_BIN)/x86_64-linux-android21-clang \
	CGO_CFLAGS="-O2 -g -I$(GMP_PATH)/$(ABI)" \
	CGO_LDFLAGS="-O2 -g -L$(GMP_PATH)/$(ABI)" \
	go build -buildmode=c-shared -o $(ANDROID_OUT)/$(ABI)/goalgo.so $(FILES)
