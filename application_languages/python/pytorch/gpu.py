import torch

from torch import nn

print(torch.device('cpu'))
print(torch.device('cuda'))
print(torch.device('cuda:1'))

print(torch.cuda.device_count())


def try_gpu(i = 0):
  if torch.cuda.device_count() >= i + 1:
    return torch.device(f'cuda:{i}')
  return torch.device('cpu')

def try_all_gpus():
  devices = [torch.device(f'cuda:{i}') ]


print(torch.device('mps'))
