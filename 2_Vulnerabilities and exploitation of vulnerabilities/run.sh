if [ -f "source.exe" ]
then
	echo "source.exe exists, deleting..."
	rm "./source.exe"
	echo "existing file deleted"
fi;

echo "compiling program ..."
gcc -m32 -o source.exe ./source.c

if [ -f "source.exe" ]
then
	echo "compiling finished"
else
	echo "compiling failed"
fi;
