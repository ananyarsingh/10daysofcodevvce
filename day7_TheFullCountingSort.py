#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the countSort function below.
def countSort(arr):
    for i in range(len(arr)):
        if i< len(arr)//2:
            arr[i][1]="-"
        arr[i][0]=int(arr[i][0])
        arr[i].insert(1,i)
    a=sorted(arr)
    for i in range(len(arr)):
        print(a[i][2],end=" ")

if __name__ == '__main__':
    n = int(input().strip())

    arr = []

    for _ in range(n):
        arr.append(input().rstrip().split())

    countSort(arr)
