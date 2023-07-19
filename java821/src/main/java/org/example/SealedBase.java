package org.example;

public sealed class SealedBase permits SealedA, SealedB {


}

 final class SealedA extends SealedBase{

}

 final class SealedB extends SealedBase{

 }

