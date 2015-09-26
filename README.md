**git fetch && git checkout master** -> Update your files to the latest.
Note: 

**Git add filename.java** -> add a file that you've made changes to. 

**git push -u origin master** -> (update files, i.e. if you made changes to a file it will push the latest revision) 

**git commit -m "xxx"** -> where XXX is changes you've made to the code i.e removed bug in this or etc..
Please Use Commit so we can know what changes are made when. This is great for debugging.

**git pull origin** ->  If you are behind use git pull origin (this just gets the changes) Whenever there are changes pushed to master you have to fetch the latest or else you're going to end up reverting w.e changes a person has done. So any time someone does a change, do this.  

|| --> **git stash MainPage.java** \n
|| --> **git stash pull origin** \n
|| --> **git stash pop** \n
|--------------------------> if you need to merge your changes with the code from bitbucket, you need to stash your main changes.

These are simple commands. If you need more contact *Edgar* for further hellp.
