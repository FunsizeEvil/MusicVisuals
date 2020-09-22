# Music Visualiser Project

Name: Daniel Foley

Student Number: C17335606

Github repo:[hyperlink](https://github.com/FunsizeEvil/MusicVisuals)


# Description of the assignment
	The assignment is a program that displays a menu and allows the user to select a 
	song and the visual to go with it. 
	[hyperlink](https://youtu.be/3p4wIpBfyow)

# Instructions
- 	Run the program through terminal commands or through Visual Studio code
- 	Menu will appear in which the user can select song and its visual

# How it works
1. 	The menu is first alled which displays a header, 3 option boxes and a footer.
	Each box can be clicked by the user which will launch a new window with
	a visual for the user. The menu uses processing to display the boxes and
	mousePressed to detect where the user clicks. It the launches a new window
	for the option choosen. The menu is also used to load track names to an
	ArrayList for the user.
 2. The AroundTheWorld visual is a model of a solar sytem that reacts to to
	the amplitude of the music. As the amplitude gets louder the planets
	rotate quicker and they grow in size. I was inpsired by Daft Punk's 
	music video and the title of their song for this visual. It starts
	by creating 7 planets for each of the bands with the first one in the 
	center. It then sets the distance of each planet and its rotation to start
	at so that they look more natural rather than in a line. The song is then 
	loaded and the orbits, rotations and size will then change based off the
	amplitude.
3. 	CubeInSphere is a visual that creates a pattern of a 12 by 12. The elements
	React to the amplitude and the bands. they grow in size with increased amplitude 
	and change colour as the avegrage band changes.


# What I am most proud of in the assignment
	I feel I am most proud of how I learned to undertand and implement functions 
	such as the map function and the processing libraries. Something I also spent
	a lot of time on was attempting to use polymorphism to create a template for 
	making patterns of differnet shapes. The idea was to have TwodObject to hold the 
	basic parameters of the objects, the have SHAPE do all the claculations and scaling
	for the amplitude and finally classes such as Square that would render and update 
	the shapes. I put a good amount of my time into this but it fell short as I couldnt
	get it to fully integrate with Visual through polymorphism. When I couldnt get this 
	to work I then started working on CubeInSphere which achieved what the TwodObject 
	would have except it was not modular like I hoped TwodObject would be.

# What I've learned from this assignment
	I feel like ive learned a lot over doing this assignment in terms of increasing my
	programming abilites. I also I learned I am not the most musically creative person
	and found it hard to come up with ideas for visuals. However I belive this to be a
	good thing as I got distracted doing other small java projects. One of which was 
	creating a version of the yasc game and trying to understand how it worked by coding
	it from scratch. [hyperlink](https://github.com/FunsizeEvil/Y.A.S.C). I used what I 
	learned here to create a the twodObject class and have shapes spin and rotate in 
	patterns using similar attributes to the ships in Y.A.S.C . I spent a large proportion
	of my time doing the Y.A.S.C program and the twodObject, SHAPE classes and felt
	I learned a lot about polymorhism from those the yasc project and this assignment.

# What would I do differently
	If I were to do this assignment again I would plan out my classes in a way that 
	would make the project more cohessive. As it stands, the program starts and main 
	calls the menu. The menu then calls a class to start in a new window. I Thought this
	would be the best way to implement the project but found toward the end of it that 
	it was incredibly clunky and non fluid. I would instead make use more polymorphism
	to create a setup class which would then call functions from other classes onto the 
	same window. 

# Final Thoughts
	Over all though I enjoyed the assingment. I found myself getting into a flow state
	when I got rolling but would be interrupted by a bug or error that would pull 
	the breaks for an hour or so. Working thorugh the errors thought me a lot and 
	led me to finding some great resources online. Not everything I came across related
	directly to what I was doing but interpretting those examples was a skill that I
	honed alot the last few weeks leading to fixing bugs in a satisfying way.



