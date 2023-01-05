#include <stdio.h>
#include <string.h>
#define MAX_LIMIT 256

// global grammar variables
char line1[MAX_LIMIT];
char line2[MAX_LIMIT];
char line3[MAX_LIMIT];
// sentence

char sentence[] = "m+(d+7)";

// Another Input: (r) + (7) + d
void rightPar()
{
  printf("%c %c %c %c %c %c %c\n", line1[0], sentence[1], sentence[2], sentence[5], sentence[6], sentence[1], sentence[0]);
  printf("Sentence not Supported..\n");
}
void leftParAndE()
{
  printf("%c %c %c %c%c%c %c %c %c\n", line1[0], sentence[1], sentence[2], line3[0], line3[1], line3[2], sentence[6], sentence[1], sentence[0]);
  rightPar();
}
void ADD_OP4()
{
  printf("%c %c %c %c %c %c %c\n", line1[0], sentence[1], sentence[2], line1[0], sentence[6], sentence[1], sentence[0]);
  leftParAndE();
}
void EandId3()
{
  printf("%c %c %c\n", line1[0], sentence[1], sentence[0]);
  ADD_OP4();
}
void EandId2()
{
  printf("%c %c %c%c\n", line1[0], sentence[1], line2[0], line2[1]);
  EandId3();
}
void E3()
{
  printf("%c %c %c\n", line1[0], sentence[1], line1[0]);
  EandId2();
}

void ADD_OP3()
{
  printf("%c\n", line1[0]);
  E3();
}

// for m+(d+7)
void rightPar2()
{
  printf("Supported Sentences..\n");
  ADD_OP3();
}

void EandNum()
{
  printf("%c %c %c %c %c %c %c\n", sentence[0], sentence[1], sentence[2], sentence[3], sentence[1], sentence[5], sentence[6]);
  rightPar2();
}
void E4()
{
  printf("%c %c %c %c %c %c%c%c %c\n", sentence[0], sentence[1], sentence[2], sentence[3], sentence[1], line3[0], line3[1], line3[2], sentence[6]);
  EandNum();
}
void EandID()
{
  printf("%c %c %c %c %c %c %c\n", sentence[0], sentence[1], sentence[2], sentence[3], sentence[1], line1[0], sentence[6]);
  E4();
}
void ADD_OP2()
{
  printf("%c %c %c %c%c %c %c %c\n", sentence[0], sentence[1], sentence[2], line2[0], line2[1], sentence[1], line1[0], sentence[6]);
  EandID();
}
void leftPar()
{
  printf("%c %c %c %c %c %c %c\n", sentence[0], sentence[1], sentence[2], line1[0], sentence[1], line1[0], sentence[6]);
  ADD_OP2();
}
void E2()
{
  printf("%c%c %c %c %c %c\n", line2[0], line2[1], sentence[1], sentence[2], line1[0], sentence[6]);
  leftPar();
}
void E()
{
  printf("%c %c %c %c %c\n", line1[0], sentence[1], sentence[2], line1[0], sentence[6]);
  E2();
}
void FIRST_CALL()
{
  printf("%c\n", line1[0]);
  E();
}

int main()
{
  int counter = 0;

  // reading grammar from file
  FILE *file = fopen("grammar.txt", "r");
  char line[MAX_LIMIT];
  while (fgets(line, sizeof(line), file))
  {
    if (counter == 0)
      strcpy(line1, line);
    else if (counter == 1)
      strcpy(line2, line);
    else
      strcpy(line3, line);
    counter++;
  }
  fclose(file);
  FIRST_CALL();
}
