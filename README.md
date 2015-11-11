# BlackjackClient
Skeleton BlackjackClient to connect to the Blackjack WebSocket server found [here](https://github.com/chadtomas/Blackjack)

## About
First, make sure you've run the Blackjack server as described in its documentation (see above). All the WebSocket configuration is already set up for the client, your job is to write the logic to send messages to the server to complete actions and bets and handle the messages being sent from the server. I've gotten you started by including the piece of code that already registers you to the game.

## Requirements
* Git
	* You could of course just download this source code directly if you don't want have time to download git.
	* If you don't have git installed, you can download it [here](https://git-scm.com/download/)
		* Install
		* Pick all the default settings
		* Git also comes with Git Bash. Highly recommended to use if you're on Windows.
		* Verify git is installed by running `git --version` in terminal
* Java 8
	* NOTE: Only needed to run the server locally OR if you'd like to write code using java 8.
	* You can verify by running `java -version` in terminal
* Maven
	* The client skeleton code provded uses Maven, so if you choose to use this client code, this is definitely needed.
	* Check if maven is already installed by running `mvn -version` in terminal
		* You can download maven [here](http://apache.cs.utah.edu/maven/maven-3/3.3.3/binaries/apache-maven-3.3.3-bin.zip)
		* After install, add environment variables (Kelly can help with this)
			* Add location of unzipped bin folder inside maven to the `PATH` environment variable
			* Add environment variable for location of `JAVA_HOME`
				* Windows users can refer [here](http://crunchify.com/how-to-setupinstall-maven-classpath-variable-on-windows-7/)

## Getting Started
### Fork the repos

##### Blackjack Server
* Go to: [https://github.com/chadtomas/Blackjack](https://github.com/chadtomas/Blackjack)
* In the upper right corner, click "Fork".
* You won't be pushing any changes to this fork unless you want to play around with the server at a later date.

##### Blackjack Client
* Go to: [https://github.com/chadtomas/BlackjackClient](https://github.com/chadtomas/BlackjackClient)
* In the upper right corner, click "Fork".
* You will later push your changes to this fork you just created.


### Clone the repos to your local computer

On you laptop, go to your terminal and into a preferred directory for programming applications.


*For the two commands below, you can use another directory name. Just make sure that the two repos you will be cloning have the same parent directory.*

	mkdir blackjack-challenge
	cd blackjack-challenge

*Be sure to plug in your own github username in place of your-github-username*

	git clone git@github.com:your-github-username/Blackjack.git
	git clone git@github.com:your-github-username/BlackjackClient.git


### Build the Client shell to make sure you're starting out right.

From parent folder (e.g., blackjack-challenge)

	cd BlackjackClient
	mvn clean install
	
### Test out your Blackjack Server locally (optional)
<mark>TODO: directions</mark>

### Test out your Blackjack Client Shell
<mark>TODO: directions</mark>


### Time to code some logic into your BlackjackClient!

Where commented, do NOT edit code that's already provided. If you do a search for "TODO", you should see all the places where your code will go. Feel free to add any methods or classes in addition to the ones already provided, should you need to use it.
