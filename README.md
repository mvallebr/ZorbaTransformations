ZorbaTransformations
====================

This is a very simples project that demonstrates how to use ZORBA implementation
to execute json 2 json transformations from Java.

You can run TestBasicTransformations class from inside Eclipse to see it in action. 
Before running, make sure the lib project folder is included in the environment
variable LD_LIBRARY_PATH  (actually, LD_LIBRARY_PATH on Linux, DYLD_LIBRARY_PATH
 on Mac, and PATH on Windows), as it uses a native dll that should be available. 
 
In the lib path there are three jar files and one .so (DLL) that comes with the 
zorba distribution. I took this from zorba 2.6 and I am including it here to 
make it easier for someone who wants this working fast, but you should take this
files from your ZORBA installation. Check http://www.zorba-xquery.com/html/download
to see how to install zorba in your environment.

The Json2JsonTransformation class is very simple. To create an instance, you should
pass a JSON transformation as a constructor argument, as String. Once you have the 
instance, connect and call the transform method, passing the json file to be 
processed as argument. The result will be processed file.

The transformation in this case should always reffer to the origin document as 
$inputdoc and should parse the document inside the transformation, using the 
jsoniq namespace (import module namespace jn = "http://www.jsoniq.org/functions";). 
I have used ZORBA 2.6.0 to create this example, you won't be able
to use this namespace in the transformation in earlier versions of ZORBA.  

Check the TestBasicTransformations unit test and the json files to see a working 
example.
