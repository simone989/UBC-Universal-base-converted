# UBC-Universal-base-converted

Installation

After unpacking the file UBC.zip to run the program, you'll have to open the terminal and type the following command (by entering the path to the program unzipped) "java Converter".
If your computer is not 'yet installed the environment java need to perform this procedure:

On Windows:
Download from here the installation files (install the files relating to the operating system), eg: jdk-8u45-windows-x64.exe
- Run the .exe file of the JDK and select the default options until full compliance.
- Then change the PATH environment variable.
The upgrade path to allow the system to find more 'javac' and 'java' must be done manually:
- Select from the control panel:
'Performance and Maintenance' -> 'System' -> 'Card:' Advanced '->' Variables 'environment'
- Section: 'System Variables' (NOT user!). Careful not to make mistakes in copying the path: C: \ Program Files \ jdk1.8.0_45;

On Linux:
-a JDK is installed by default during installation of the same in the most common installations; if not, just download and install the package.

System Requirements

The program can 'be run on any operating system that supports Java (tested on Windows 7, Windows XP, Windows Vista and Ubuntu 11.04 etc.).
The software needed to run the program are: v JVM. 1.2. and JDK 6.0 or higher.
The hardware required for proper operation are: a processor type Intel Pentium or AMD freq. 300 MHz or faster processor, a 112 MB RAM or higher, a monitor with a minimum resolution of 800x600 pixels or higher and also the typical input devices (eg. Keyboards, mice, video etc.).


Compilation

To compile the source folder Converter (education applies to both windows for linux): Enter the src folder via terminal and run: "javac -encoding UTF-8 -d ../bin Convertitore.java". After the compilation is over, always go through the terminal in the "bin" and from there run the command to start the program "java Converter"
