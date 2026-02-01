import numpy as np
import cv2
import argparse
import os
from time import sleep
characters = [" ", ".", ",", "~", ";", "=", "!", "*", "f", "#", "@", "■"]

def conv_img(img:str, pix_size:int,rows,cols):
    new_img = np.zeros((rows // pix_size +1, cols // pix_size + 1), dtype=np.float32)

    for i in range(0, rows, pix_size):
        for j in range(0, cols, pix_size):
            block = img[i:i+pix_size, j:j+pix_size]
            avg = np.mean(block)
            new_img[i//pix_size, j//pix_size] = avg
    return new_img.astype(np.uint8)

def ascii_out(img,rows,cols):
    for i in range(rows):
        for j in range(cols):
            print((characters[int(img[i,j]//22)])*2, end="")
        print() 
        
def colour_out(img,rows,cols,pix_size):
    col_img = cv2.imread(f"images/{img}")
    for i in range(rows):
        for j in range(cols):
            colour = col_img[i*pix_size,j*pix_size]
            print(f"\033[38;2;{colour[2]};{colour[1]};{colour[0]}m" + "█"*2, end="")
        print("\033[0m")
        
def ascii_colour_out(img,rows,cols,pix_size,img_name):
    col_img = cv2.imread(f"images/{img_name}")
    
    for i in range(rows):
        for j in range(cols):
            colour = col_img[i*pix_size,j*pix_size]
            print(f"\033[38;2;{colour[2]};{colour[1]};{colour[0]}m" + characters[int(img[i,j]//22)]*2, end="")
        print("\033[0m")
        
def render_video(path,height):
    vidObj = cv2.VideoCapture(path+".mp4") 
  
    # Used as counter variable 
    count = 0
  
    # checks whether frames were extracted 
    success, image = vidObj.read() 
    cv2.imwrite(f"{path}/frame{count}.jpg", image)
    while success: 
        count += 1
        cv2.imwrite(f"{path}/frame{count}.jpg", image) 
        success, image = vidObj.read() 
        
    for i in range(7000):
        img = cv2.imread(f"{path}/frame{i}.jpg", 0)  
        rows, cols = img.shape
        pix_size = rows // height
        if height > rows:
            pix_size = 1
        new_img = conv_img(img,pix_size,rows,cols)
        # ascii_out(new_img,rows//pix_size-1,cols//pix_size-1)
        ascii_colour_out(new_img,rows//pix_size-1,cols//pix_size-1,pix_size,f"rick/frame{i}.jpg")
        # colour_out(f"rick/frame{i}.jpg",rows//pix_size-1,cols//pix_size-1,pix_size)
        #sleep(0.1)
        #os.system('cls')
        
    
    
if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Process an input value.")
    parser.add_argument("file", type=str, help="The input value to be processed")
    parser.add_argument("--height", type=str, help="The input value to be processed")
    args = parser.parse_args()  
    
    img = cv2.imread(f"images/{args.file}", 0)  
    rows, cols = img.shape
    if args.file is None:
        args.file = "rick.jpg"
    if args.height is None:
        args.height = 64
    pix_size = rows // int(args.height)
    if int(args.height) > rows:
        args.height = rows
        pix_size =1

    new_img = conv_img(img,pix_size,rows,cols)
    # ascii_out(new_img,rows//pix_size,cols//pix_size)
    # sleep(0.5);os.system('cls')
    #ascii_colour_out(new_img,rows//pix_size,cols//pix_size,pix_size,args.file)
    # sleep(0.5);os.system('cls')
    colour_out(args.file,rows//pix_size,cols//pix_size,pix_size)
    
    
    #render_video("images/rick",int(args.height))
    
    
