#include <stdio.h>
#include <stdlib.h>


int main(){

	int a = 0;
	int b = 0;


	scanf("%d", &a);
	scanf("%d", &b);
	if(a < b){
		while(a < b){
		printf("%d", a);		a = a+1;
	}	}else {
		printf("a nao emenor que b");
	}
return 0;
}