# MagicSnackBar
SnackBar creator module for Android like Pokémon Go.

How to use:

![alt text](https://github.com/IsMMA/MagicSnackBar/blob/main/example.gif "SnackBar")


Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.IsMMA:MagicSnackBar:1.0.2'
	}

Step 2 (if step 2 fails) Add in settings.gradle

 repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
      ...
        maven { url 'https://jitpack.io' }
      
    }

And:

 	private MagicSnackBar magicSnackBar;
 
	  @Override
	    protected void onCreate(Bundle savedInstanceState) {
		...
		
		//Instance
		magicSnackBar = new MagicSnackBar(this);
		
		//Launch snackbar (blue)
		magicSnackBar.snackBar("Hello world");
		
		//Launch error snackbar (red)
		magicSnackBar.snackBarError("Error");
		
		//Change duration (in mills):
		magicSnackBar.setDuration(4000);
		
		...
	    }

Only works with Love ❤️
