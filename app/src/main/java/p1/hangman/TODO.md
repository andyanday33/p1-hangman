# TO DO List

1. Document the code, find the mistakes.
2. Test the code extremely, find the problems.
3. Add comments where necessary.
4. Change the implementation slighty wherever necessary.


## Problems with the code

### 1. General

- Code is not documented.
- There are zero comments.
- The game is giving more than 2 hints.
- The game is giving a "Wrong Guess!" feedback when taking a hint. _DONE_
- Guessing capital letters are not working.
- 

### 2. App class

- method name doStuff is not appropriate. _DONE_
- GameState g is not used inside doStuff() 

## 3. CommandOpts class

- WordSource is always "". _WRONG INFERENCE_

## 4. GameState class

- Add getters/setters instead of directly manipulating stuff. _DONE_

## 5. Words class

- Variable names are bad. _DONE_
- States only has Alabama in it.
- Check the random indexes, seems malfunctional.
- 