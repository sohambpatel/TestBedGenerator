# Code smell: Hardcoded values
variable "aws_region" {
  default = "us-west-2"
}

resource "aws_instance" "example" {
  ami           = "ami-12345678"
  instance_type = "t2.micro"
  subnet_id     = "subnet-abcdef1234567890"
  security_group_ids = ["sg-0123456789abcdef0"]
}

# Security vulnerability: Hardcoded credentials
provider "aws" {
  access_key = "my-access-key"
  secret_key = "my-secret-key"
  region     = var.aws_region
}

# Code smell: Unused resource
resource "aws_security_group" "unused_sg" {
  name        = "unused-sg"
  description = "Unused security group"
  vpc_id      = "vpc-0123456789abcdef0"
}

# Coding issue: Incorrect instance count
resource "aws_instance" "example_count" {
  ami           = "ami-12345678"
  instance_type = "t2.micro"
  subnet_id     = "subnet-abcdef1234567890"
  security_group_ids = ["sg-0123456789abcdef0"]

  count = 2  # Incorrectly set to 2 instances
}

# Code smell: Unnecessary resource attributes
resource "aws_instance" "example_unnecessary_attrs" {
  ami           = "ami-12345678"
  instance_type = "t2.micro"
  subnet_id     = "subnet-abcdef1234567890"
  security_group_ids = ["sg-0123456789abcdef0"]

  tags = {
    Name        = "example-instance"
    Environment = "production"
  }

  ebs_block_device {
    device_name = "/dev/sda1"
    volume_type = "standard"
    volume_size = 20
  }
}

# Security vulnerability: Outputting sensitive information
output "database_password" {
  value = "supersecretpassword"
}
