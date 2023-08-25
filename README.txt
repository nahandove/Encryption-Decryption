Project assignment from JetBrains Academy (www.hyperskill.org), Java Developer track.

This project encrypt and decrypt a body of text from either the command line or from a supplied file.

The user provides arguments via the command line. The arguments are listed as below. If no argument is
specified, the program executes the default command.

List of available arguments:

-alg: specifies which coder to use. Two coders are available to encode and decode a body of text which
can be specified by the next argument:

	1. shift: a coder using Caesar cipher. It shifts alphabets according to a user-specified integer key. 
	If the end of the alphabet is reached, it returns to the beginning of the alphabet, thus is 
	circular. The coder can also decode the cipher by shifting the alphabets backwards using the 
	supplied key. All non-alphabetic characters are ignored and output as is.

	The shift coder is the default coder and will be used absent of an argument.

	2. unicode: a coder that shifts the input forward, including non-alphabetic character. The coder
	is linear and shifts the character forward according to a user-specified integer key. The coder
	decodes the cipher by shifting the characters backward.

-mode: specifies whether the coder would encode or decode the supplied text. The next argument specifies
the method:
	1. enc: encodes the text. This is the default method.
	2. dec: decodes the text.

-key: an integer that specifies the number of positions the text should shift. If key is not supplied, the
coder outputs the text as is.

-in: the user specifies in the next argument a file name which the program will read the text from. If the
argument is not present, the program uses -data instead (see next entry)

-data: the user supplies the input text in the next argument. If both -in and -data are present, the
program preferentially choose -data.

-out: the user specifies in the next argument a file name to output the resulting text. if the argument is
not present, the program outputs the text to the console.

If the user makes a mistake while inputing commands, or if the input and output files specified do not exist,
they will be informed of their errors and the program ends.

August 24th, 2023--description by E. Hsu (nahandove@gmail.com)