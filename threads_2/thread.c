#include <stdio.h>
#include <pthread.h>

pthread_t tid1, tid2;
int a = 0;

pthread_mutex_t mutex;

void * p1(){
    int i;
    for(i = 0; i < 1000000; i++)
    {
        pthread_mutex_lock(&mutex);
            a = a + 2;
        pthread_mutex_unlock(&mutex);
    }
}

void * p2(){
    int i;
    for(i = 0; i < 1000000; i++)
    {
        pthread_mutex_lock(&mutex);
            a = a + 5;
        pthread_mutex_unlock(&mutex);
    }
}

int main(int argc, char const *argv[])
{
    int result, i;
    pthread_mutex_init(&mutex, NULL);
    result = pthread_create(&tid1, NULL, p1, NULL);
    result = pthread_create(&tid2, NULL, p2, NULL);
    
    pthread_join(tid1,  NULL);
    printf("Thread 1 Finished: %d \n", a);
    pthread_join(tid2,  NULL);
    printf("Thread 2 Finished: %d \n", a);
    return 0;
}
