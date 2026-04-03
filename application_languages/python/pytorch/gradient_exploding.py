import torch

M = torch.normal(0, 1, size=(4, 4))
print('one matrix \n', M)

for i in range(100):
  M = torch.mm(M, torch.normal(0, 1, size=(4, 4)))
print('multiplication 100 \n', M)
