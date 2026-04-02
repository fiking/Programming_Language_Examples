import torch

y = torch.tensor([1,2,3,4])  # 一维 (4,)
print(y.shape)

y_new = y.reshape((-1, 1))   # 变成 列向量 (4,1)
print(y_new.shape)
print(y_new)
