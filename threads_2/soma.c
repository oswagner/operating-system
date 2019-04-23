#include <stdio.h>
#include <pthread.h>

time_t t;

pthread_t writer, reader1, reader2;
int values[2];
int result;

pthread_mutex_t can_write;

int generate_number() {
    return rand() % 100 + 1;
}

void * write() {
    while(1) {
        pthread_mutex_lock(&can_write);
            values[0] = rand() % 100 + 1;
            values[1] = rand() % 100 + 1;
            printf("writer a[%d] + b[%d]\n", values[0], values[1]);
        pthread_mutex_unlock(&can_write);
    }
}

void * read() {
    while(1) {
        pthread_mutex_lock(&can_write);
            int a = values[0];
            int b = values[1];
            result = a + b;
            printf("reader a[%d] + b[%d] = c[%d]\n", a, b, result);
        pthread_mutex_unlock(&can_write);
    }
}

int main(int argc, char const *argv[])
{
    pthread_mutex_init(&can_write, NULL);
    pthread_create(&writer, NULL, write, NULL);
    pthread_create(&reader1, NULL, read, NULL);
    pthread_create(&reader2, NULL, read, NULL);
    
}
