import os
import pandas as pd
import torch

os.makedirs(os.path.join('..', 'data'), exist_ok=True)
data_file = os.path.join('..', 'data', 'house_tiny.csv')
with open(data_file, 'w') as f:
    f.write('NumRooms,Alley,Price\n') # 列名
    f.write('NA,Pave,127500\n') # 每行表示一个数据样本
    f.write('2,NA,106000\n')
    f.write('4,NA,178100\n')
    f.write('NA,NA,140000\n')

print(f'Data file created at: {data_file}')

data = pd.read_csv(data_file)
print(data)

inputs, outputs = data.iloc[:, 0:1], data.iloc[:, 2]
inputs = inputs.fillna(inputs.mean())
print(inputs)
print(outputs)

inputs = pd.get_dummies(inputs, dummy_na=True)
print(inputs)


x = torch.tensor(inputs.to_numpy(dtype=float))
y = torch.tensor(outputs.to_numpy(dtype=float))
print(x)
print(y)

x = torch.tensor(3.0)
y = torch.tensor(2.0)
print(x + y)
print(x - y)
print(x * y)


x = torch.arange(4)
print(x)
print(x[3])


A = torch.arange(20, dtype=torch.float32).reshape(5, 4)
B = A.clone()
print(A)
print(A + B)

print(torch.norm(torch.ones((4, 9))))