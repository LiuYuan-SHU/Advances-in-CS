// the source code provided by the PPT

#include <stdio.h>
#include <string.h>

#define PASSWORD "1234567"

int verify_password(char* password)
{
	int authenticated;	// sotore the result of comparation
	char buffer[8];		// add local buff to be overflowed
	authenticated = strcmp(password, PASSWORD);
	strcpy(buffer, password);
	return authenticated;
}

int main()
{
	int valid_flag = 0;
	char password[1024];
	while(1)
	{
		printf("please input password: " );
		scanf("%s", password);
		valid_flag = verify_password(password);
		if(valid_flag)
		{
			printf("incorrect password!\n");
		}
		else
		{
			printf("Congratulation! You have passed the verification!\n\n");
			break;
		}
	}
}
