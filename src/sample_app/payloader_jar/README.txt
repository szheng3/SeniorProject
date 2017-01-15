This package has an example folder. In it you will find a two files:
    1) msg.txt - the file to be payload
    2) original.png - the image for holding the payload

Begin by first creating the payloaded image.
Within the base directory holding payloader.jar, execute the following:
    % java -jar payloader.jar -p ./example/original.png ./example/payloaded.png ./example/msg.txt
The msg.txt file should now be contained within the metadate of image payloaded.png.
Here the payload was a text file, but it can be of any type.

Try viewing the two images, they should be exact visual duplicates.
Then, try calling the following two commands:
    % java -jar payloader.jar -i ./example/original.png
    % java -jar payloader.jar -i ./example/payloaded.png
This command will inspect the chunks within a png byte stream.
As each chunk within the byte stream is encountered, information about the chunk
gets printed to the console. If the the payloading process was successful, there should be
a chunk type "puNK" that is found in payloaded.png but not original.png.

Lastly, to remove the payload from the image, issue the following command:
    % java -jar payloader.jar -r ./example/payloaded.png ./example/extracted
Afterward, msg.txt should now be found within the directory /example/extracted.
Notice how the name of the payload file was not provided. This is because the
payload file name is stored within the payloaded image, thus a directory for the
extracted image is provided. Therefore, it's best to create a new output directory
each extraction to prevent any unwanted overwrites.

